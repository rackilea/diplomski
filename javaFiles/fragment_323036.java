ReportEngine engine = new ReportEngine(new EngineConfig());

// open design document
IReportRunnable runnable = engine.openReportDesign(this._ServletContext
    .getRealPath("/")
    + reportPath.get_Path());

IRunAndRenderTask task = engine.createRunAndRenderTask(runnable);

for (Entry<String, Object> ent : reportParams.entrySet()) {
    task.setParameterValue(ent.getKey(), ent.getValue());
}

task.setParameterValue("data_url", this._DataUrl);
task.setParameterValue("user_name", this._UserName);
task.setParameterValue("user_password", this._UserPassword);

task.setLocale(locale);

final IRenderOption options = new RenderOption();
options.setOutputFormat("pdf");
options.setOutputStream(os);

task.setRenderOption(options);
task.run();

task.close();
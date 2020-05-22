@RestController
public class AutoPrintLaunchingController {

@Autowired
private JobLauncher jobLauncher;

@Autowired
private AutoPrint autoprint;

@RequestMapping(value = "/jobs/AutoPrint", method = RequestMethod.POST)
@ResponseStatus(HttpStatus.ACCEPTED)
public void launch(@RequestParam("Drucker") String printer, @RequestParam("Fach") String fach,
        @RequestParam("Dokument") String doc, @RequestParam("DokumentParameter") String param) throws Exception {

    JobParametersBuilder jpb = new JobParametersBuilder();
    jpb.addString("Drucker", printer);
    jpb.addString("Fach", fach);
    jpb.addString("Dokument", doc);
    jpb.addString("DokumentParameter", param);
    jpb.addDate("dateInstant", Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));

    JobParameters jobParameters = jpb.toJobParameters();
    this.jobLauncher.run(autoprint.createAutoPrintJob(), jobParameters);
}

}
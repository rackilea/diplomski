@RequestMapping("/runbatchfileparam/{param:.+}")  
public ResultFormat runbatchFile(@PathVariable("param") String fileName) 
{  
RunBatchFile rbf = new RunBatchFile();  
return rbf.runBatch(fileName);  
}
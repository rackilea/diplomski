while(!allFinished) {
    for (ShellScriptProcess sp : shellScriptProcesses) {
      allFinished = true;
      if (sp.isFinished()) {
          // hurray, a process has finished, inform the UI
          // you want to do something smarter here though, 
          //like removing the finished processes from the list
      }
      else {
          allFinished = false;
      }
   }
}
Process javaProcess = new Process();
javaProcess.StartInfo.FileName = "C:\\Path\\To\\yourJavaProgram.jar";
javaProcess.StartInfo.Arguments = "EXECUTE_FROM_C_SHARP"; //or whatever
javaProcess.Start();

//Wait for the Java program to finish doing its thing before resuming
javaProcess.WaitForExit();
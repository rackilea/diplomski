DETACHED_PROCESS = 8
Popen(['java', 
       '-cp', 
       'C:/Python27/pdfbox-app-2.0.0-RC3.jar;C:/Python27/jprint.jar',
       'JPrint'],
      creationflags=DETACHED_PROCESS)
{
  "name": "Java",
  "type": "java",
  "request": "launch",
  "stopOnEntry": true,
  "preLaunchTask": "build",
  "jdkPath": "${env:JAVA_HOME}/bin",
  "sourcePath": ["${workspaceRoot}/src/my/package"],
  "cwd": "${workspaceRoot}",
  "startupClass": "my.package.classname",
  "options": [
    "-classpath",
    "${workspaceRoot}/bin"      
  ]
}
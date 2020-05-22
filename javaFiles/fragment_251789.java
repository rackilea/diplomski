{
    "cmd": ["javac '$realpath$file' && java $file_base_name && rm *.class"],
    "selector": "source.java",
    "shell": true,
    "variants": [

        {
            "name": "JavaDoc",
            "cmd": ["mkdir documentation && javadoc -d documentation *.java"]
        },

        {
            "name": "JAR",
            "cmd": ["javac '$realpath$file' && echo \"Main-Class: $file_base_name\" > Manifest.txt && jar cfm $file_base_name.jar Manifest.txt *.class && rm *.class && java -jar $file_base_name.jar"]
        },


    ]
}
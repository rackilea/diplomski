$result = shell_exec("java -jar /path/to/imageprocessor.jar " + $imagepath);
if ($result) {
    // Shell execution succeed.
} else {
    // Shell execution failed.
}
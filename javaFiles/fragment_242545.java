fun main(){

   val path1 = "video-1.mp4"
   val path2 = "video-2.mp4"
   val resultPath = "output.mp4"

   val cmd = arrayOf("ffmpeg",
    "-i", path1, "-i", path2,
    "-filter_complex", "[0:v:0][0:a:0][1:v:0][1:a:0]concat=n=2:v=1:a=1[v][a]",
    "-map", "[v]", "-map", "[a]", resultPath)

    executeCommand(cmd)
}

fun executeCommand(cmd: Array<String>){
    try {
       val runtime = Runtime.getRuntime()
       val process = runtime.exec(cmd)
       val errorStream = process.errorStream
       val input = InputStreamReader(errorStream)
       val reader = BufferedReader(input)
       reader.forEachLine {
          println(it);
       }
       process.waitFor()
   } catch (e: Exception) {
       e.printStackTrace();
   }
}
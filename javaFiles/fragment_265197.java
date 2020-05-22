bufferedWriter.write("BufferedReader\n"); -> buf[0..n]
printWriter.println("PrintWriter"); -> buf[n+1...m]
fileWriter.write("FileWriter\n"); -> file[0..a]

//implicit close
bufferdWriter.close(); buf[0..m] -> file[a+1..a+m]
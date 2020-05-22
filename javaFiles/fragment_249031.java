public void WriteOutput( ArrayList<detailTom> tomData1){
      try{
          BufferedWriter writer = new BufferedWriter(new FileWriter("G:/sampleOutput.txt"));
          for (detailTom detail : tomData1) {
  writer.write(detail.toString());
            }
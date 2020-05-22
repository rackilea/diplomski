try (FileWriter fw = new FileWriter(file.getAbsoluteFile()); BufferedWriter bw = new BufferedWriter(fw)) {
      // Write the data to the memory
      bw.write(content);
      // You need to flush the data
      bw.flush();
      // Close the BufferedWriter
      bw.close();
} catch (Exception ex) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Failed to write the data on the file", ex);
}
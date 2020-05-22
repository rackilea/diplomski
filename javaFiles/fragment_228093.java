while ((line = reader.readLine()) != null) {
    final String appendLine = line + "\n";
    System.out.println("" + line);
    SwingUtilities.invokeLater(new Runnable(){ 
        public void run(){    
            jTextArea1.append(appendLine);
        }
    });
}
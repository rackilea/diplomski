// Replace this line 

    File fileName = new File(chooser.getSelectedFile() + "");

    // With following code
    String _fileName = chooser.getSelectedFile();

    if(_fileName != null && !_fileName.endsWith(".txt")){
        _fileName = _fileName + ".txt";
    }

    File fileName = new File(_fileName);
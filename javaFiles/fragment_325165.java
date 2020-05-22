for (int i = 0; i < s2.length; i++) {
    if (s2[i] .equals("elect")|| s2[i] .equals("selct") || s2[i].equals("slect" )|| s2[i].equals("selec")|| s2[i].equals("seect")
    {
        textArea2.setText("use 'select' instead of " + s2[i]);
    }
    else if (s2[i] == "updat" || s2[i] == "updae" || s2[i] == "updte" || s2[i] == "upate") {
        textArea2.setText("use 'update' instead of " + s2[i]);
    }

    else if (s2[i] == "delet" || s2[i] == "delte" || s2[i] == "elete" || s2[i] == "dlete") {
        textArea2.setText("use 'delete' instead of " + s2[i]);
    }
    else if (s2[i] == "fro" || s2[i] == "frm" || s2[i] == "fom") {
        textArea2.setText("use 'from' instead of " + s2[i]);
    }
}
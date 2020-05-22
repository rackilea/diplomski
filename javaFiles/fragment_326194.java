public void actionPerformed(ActionEvent e)  
{  
    String s = txt.getText();  
    char[] cArr = s.toCharAray();  
    ArrayList<Character> chars = new ArrayList<Character>();  
    for (char c : cArr)  
        if (c.isDigit())  
            chars.add(c);  
    cArr = new char[chars.size()];  
    for (int i = 0;i<chars.size();i++)  
        cArr[i] = char.get(i);  
    s = new String(cArr);  
    txtField.setText(s);  
    if (s.equals(""))  
    {  
        // issue warning  
        return;  
    }  
    int input = Integer.parseInt(s);  
    if (input >=  1800 && input <= 2013)  
    {  
        // do stuff  
    }  
}
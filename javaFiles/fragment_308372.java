btnSubmitCode.setOnClickListener(new OnClickListener()
    {
        @Override
        public void onClick(View arg0)
        {
            String str = editText_Code.getText().toString();

            if(str == null || str.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Please Enter Code", Toast.LENGTH_SHORT).show();
            }
            else
            {
                String strCode = str.trim();
                if(checkCode(strCode))
                {
                    System.out.println("word is match");   
                }
                else
                {
                    System.out.println("word is not match");                    
                }
            }
        }
    }
);
...
...

// Returns true if the code has already been used
// Returns false if the code is new
// Creates mynote.txt if it doesn't exist
// Appends code if it is new
private boolean checkCode(String code)
{
    String temp;
    File file = new File(getFilesDir() + "mynote.txt");

    if(file.exists())
    {
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(file));
            temp = in.readLine();
            while (temp != null)
            {
                if(code.equals(temp))
                {
                    // Match was found
                    // Clean up and return true
                    in.close();
                    return true;
                }

                temp = in.readLine();
            }
            in.close();
        }
        catch (FileNotFoundException e)
        {

        }
        catch (IOException e)
        {

        }

    }

    // Match was not found or File doesn't exist
    // Append code to mynote.txt and return false
    try
    {
        BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
        out.newLine();
        out.write(code);
        out.close();
    }
    catch (IOException e)
    {

    }

    return false;
}
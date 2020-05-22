public static ArrayList<String> XmlComma(List<Character> input) {
        ArrayList<String> result = new ArrayList<String>();
        String output = "";
        for(int i = 0; i < input.size(); i++)
        {
            if(i != (input.size() -1))
            {
                if(!input.get(i).equals(','))
                {
                    output += input.get(i);
                }
                if(input.get(i).equals('>') && input.get(i+1).equals('<'))
                {               
                    result.add(output);
                    output = "";
                }
            }
            else
            {
                output += '>';
                result.add(output);
            }
        }
        return result;      
    }
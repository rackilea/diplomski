while(st.length() > 0)
{   

    for(int i_map = 0; i_map < charCodeArrayList.size(); i_map++)
    {
        CharCode cc = charCodeArrayList.get(i_map);

        if(st.startsWith(cc.getCode()))
        {
            System.out.println("found: " +  cc.getChr());
            st = st.substring(cc.getCode().length()); 
            break;
        }//end if

    }//end for      

}//end while
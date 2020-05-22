public class HirerarchicalConfig{

    public static boolean checkIfNodeExists(String nodeName,XMLConfiguration config){       
        if(!config.configurationAt(nodeName).isEmpty())
            return true;
        else 
            return false;       
    }   
    public static void main(String[] args) throws ConfigurationException{       

        XMLConfiguration config = new XMLConfiguration("configFile.xml");
        boolean aliasesNode = checkIfNodeExists("aliases",config);
        System.out.println(aliasesNode);        
    }
}
public void addLoggerToSecurityGroup(NamingEnumeration ldapAttributes,List<String> securityGroups){
    while (ldapAttributes.hasMore()) {
        Attribute attr = (Attribute) (ldapAttributes.next());
        for (int i = 0; i < attr.size(); i++) {
            if (attr.get(i).toString().startsWith("CN=GG-PaaS-logging-service")) {
                String commonName = attr.get(i).toString();
                int startIndex = commonName.indexOf("=") + 1;
                int endIndex = commonName.indexOf(",");
                commonName = commonName.substring(startIndex, endIndex);
                securityGroups.add(commonName);
            }
        }
    }
}
String entryDNGroup = "CN=" + groupName +","+aDauthSettings.getDomainCreateUserPath();
            try{
                Attributes attrsGroup = new BasicAttributes(true);
                // Create the objectclass to add
                Attribute objClassesGroup = new BasicAttribute("objectClass");
                objClassesGroup.add("group");
                attrsGroup.put(objClassesGroup);                
                attrsGroup.put("samAccountName", groupName);
                attrsGroup.put("cn", groupName);

                ldapContext.createSubcontext(entryDNGroup, attrsGroup);
                return true;
            } catch (NameAlreadyBoundException e) {
                return false;
            } catch (OperationNotSupportedException e) {
                e.printStackTrace();
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
Principal principal = sslEngine.getSession().getPeerPrincipal();

            if (principal.getName().contains(SNI_HOST_NAME)) {
                System.out.println("available ... ");
            }else {
                System.out.println("Not available");
            }
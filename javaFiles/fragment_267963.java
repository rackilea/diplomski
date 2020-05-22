@RequestMapping(value="/clearClientSecret",method= {RequestMethod.POST,RequestMethod.GET})
    public void clearClientSecret(HttpServletRequest request,HttpServletResponse response) {
        try {
            String path=CLIENT_SECRET_PATH+File.separator+"client_secrets";
            FileUtils.deleteDirectory(new File(path));
            response.sendRedirect("/dashboard");// redirect to your oauth request URI
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
try {
            userService.addUser(name,email, pwd);
        } catch (ShowAbleException e) {
            // if adding triggered an error it must be displayed on the page
            List<String> errors = new ArrayList<String>();
            errors.add(e.getMessage());

            return Response.ok(new SignUpView(errors)).build();
        }

        try {
            //return Response.created(new URI("/")).entity(response).build();
            return Response.seeOther(new URI("/")).build(); // redirect back to homepage...
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e);
        }
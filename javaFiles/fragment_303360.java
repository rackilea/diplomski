if(email!= null){
PasswordRecoverer pr = PasswordRecoverer.create(email);
    p.rint(1, pr.key);
    }
   else{
       // Logic for when you do not have email
    }
    p.rint(6, pr.key);
    pr.save();
    p.rint(7,pr.key);
    p.rint(pr.key);
    p.rint(8,pr.key);

pr.save();

render("App/forgot-pwd.html")
  }
}
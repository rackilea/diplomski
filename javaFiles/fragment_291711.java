if(null != user)
{
    userService.addUser(user);

    Thread mailSenderThread = new Thread(new Runnable()
    {
        public void run()
        {
            mailService.sendActivationEmail(user);
        }
    });
    mailSenderThread.start();
}
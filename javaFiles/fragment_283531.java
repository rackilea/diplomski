@Autowired
public void setMailSender(JavaMailSender mailSender) {
    this.mailSender = mailSender;
}

@Autowired
public void setVelocityEngine(VelocityEngine velocityEngine) {
    this.velocityEngine = velocityEngine;
}
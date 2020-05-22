int maxpassiveday;

@Value("${user.maxpassiveday}")
public void setMaxPassiveDay(final String maxpassiveday) {
   int tmp = Integer.parseInt(maxpassiveday);
   if (tmp < 100) {
      this.maxpassiveday = tmp;
   }
}
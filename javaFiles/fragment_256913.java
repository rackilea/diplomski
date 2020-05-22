private void solveCaptcha(String apiKey) {
            String googleKey = "6Lcsv3oUAAAAAGFhlKrkRb029OHio098bbeyi_Hv"; 
            String pageUrl = "https://secure.runescape.com/m=weblogin/loginform?theme=oldschool&mod=www";
            TwoCaptchaService service = new TwoCaptchaService(apiKey, googleKey, pageUrl);         

            try {
                String responseToken = service.solveCaptcha();

                System.out.println("Solved and Generated Response Token: " + responseToken);
                JavascriptExecutor js = (JavascriptExecutor) driver;

                js.executeScript("document.getElementById('g-recaptcha-response').innerHTML = '" + responseToken + "';");
                Thread.sleep(500);


                js.executeScript("onSubmit()");
            } catch (InterruptedException e) {
                System.out.println("ERROR case 1");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("ERROR case 2");
                e.printStackTrace();
            }
        }
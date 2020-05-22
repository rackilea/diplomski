try
        {
            string test = "COM1";
            SMSCOMMS SMSEngine = new SMSCOMMS(ref test);
            SMSEngine.Open();
            SMSEngine.SendSMS("09xxxxxxxxx", "THIS IS YOUR MESSAGE");
            SMSEngine.Close();

        }
        catch (Exception ee) {
            MessageBox.Show(ee.Message);
        }
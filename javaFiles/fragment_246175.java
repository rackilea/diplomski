private IWebDriver driver;
        [SetUp]
        public void SetUp()
        {
            // Here i just create browser as you (firefox, chrome etc);
            driver = CreateBrowser("http://www.oanda.com/currency/table");
        }

        [TearDown]
        public void TearDown()
        {
            driver.Dispose();
        }

        [Test]
        public void PortTest()
        {
            var dateElement = driver.FindElement(By.Name("date"));
            dateElement.SendKeys("12/04/10");

            var dateFrmt = driver.FindElement(By.Name("date_fmt"));
            dateFrmt.SendKeys("yy/mm/dd");

            var curr = driver.FindElement(By.Name("exch"));
            curr.SendKeys("US Dollar.USD");

            var crr = driver.FindElement(By.Name("dest"));
            crr.Click();
            WaitUntilLoad();
            var table = driver.FindElement(By.Id("converter_table"));
            Console.Write("the text is " + table.Text);
        }

        public void WaitUntilLoad()
        {
            int repetitionCount = 0;
            bool isLoaded = false;
            while (!isLoaded)
            {
                var table = driver.FindElements(By.Id("converter_table")).Count;
                if (table > 0 )
                    isLoaded = true;
                Thread.Sleep(250);
                repetitionCount++;
                Console.WriteLine("Searching again for element");
                if (repetitionCount > 25) break;
            }
        }
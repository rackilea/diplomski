final HtmlSubmitInput importBtn = (HtmlSubmitInput)importForm.getInputByValue("Import");
            HtmlPage page4 = importBtn.click();

            //  loops until the page changes.
            while(page4 == page3) {
                // The page hasn't changed.
                Thread.sleep(500);

            }
            System.out.println("Import Page: " + page4.asText());
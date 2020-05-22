NodeList nodeList = document.getElementsByTagName("a");
            for (int i = 0; i < nodeList.getLength(); i++)
            {
                Node node= nodeList.item(i);
                EventTarget eventTarget = (EventTarget) node;
                eventTarget.addEventListener("click", new EventListener()
                {
                    @Override
                    public void handleEvent(Event evt)
                    {
                        EventTarget target = evt.getCurrentTarget();
                        HTMLAnchorElement anchorElement = (HTMLAnchorElement) target;
                        String href = anchorElement.getHref();
                        //handle opening URL outside JavaFX WebView
                        System.out.println(href);
                        evt.preventDefault();
                    }
                }, false);
            }
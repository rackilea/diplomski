Connected to the target VM, address: '127.0.0.1:62943', transport: 'socket'
Starting ChromeDriver 71.0.3578.33 (269aa0e3f0db08097f0fe231c7e6be200b6939f7) on port 15369
Only local connections are allowed.
Nov 13, 2018 11:07:46 AM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: OSS
getText() works as normal for *VISIBLE* containers and paragraphs.
CONTAINER: Our mission is to organize the world’s information and make it universally accessible and useful.
LIST OF PARAGRAPHS, Size = 1   [[[[[ChromeDriver: chrome on MAC (bbb9840f94250510047ac8e04b055d88)] -> class name: home-hero-copy]] -> tag name: p]]
PARAGRAPH: Our mission is to organize the world’s information and make it universally accessible and useful.
SET THE JAVA DEBUGGER TO PAUSE RIGHT HERE, GO INTO THE BROWSER AND INJECT "display: none;" as a style on the div.home-hero-copy element to makethe div and its child paragraphs invisible. You can do this by using the developer tools elements panel.
If you've made the container invisible, you should notice that in the following block of printouts that we've still got references to the WebElements (they aren't stale) but when we try to getText() while they are invisible from 'display: none;', we won't get any text back.
CONTAINER: 
LIST OF PARAGRAPHS, Size = 1   [[[[[ChromeDriver: chrome on MAC (bbb9840f94250510047ac8e04b055d88)] -> class name: home-hero-copy]] -> tag name: p]]
PARAGRAPH: 
Now, let's try getting the text via 'innerText' with a Javascript Executor
CONTAINER: Our mission is to organize the world’s information and make it universally accessible and useful.
LIST OF PARAGRAPHS, Size = 1   [[[[[ChromeDriver: chrome on MAC (bbb9840f94250510047ac8e04b055d88)] -> class name: home-hero-copy]] -> tag name: p]]
PARAGRAPH: Our mission is to organize the world’s information and make it universally accessible and useful.
As you can see, getting inner text works when the element is invisible!
Disconnected from the target VM, address: '127.0.0.1:62943', transport: 'socket'

Process finished with exit code 0
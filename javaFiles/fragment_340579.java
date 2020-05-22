package de.scrum_master.stackoverflow;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BrowserRemoteControl {
  private static final Clipboard CLIPBOARD = Toolkit.getDefaultToolkit().getSystemClipboard();
  private static final Robot ROBOT = createRobot();

  public static void main(String[] args) throws IOException, InterruptedException, AWTException {
    startChrome();
    List<String> sites = Arrays.asList("youtube.com", "facebook.com");
    for (String site : sites) {
      setClipboardContent(site);
      enterURLFromClipboard();
      createNewBrowserTab();
    }
  }

  private static Robot createRobot() {
    try {
      return new Robot();
    } catch (AWTException e) {
      throw new RuntimeException("Cannot create Robot instance", e);
    }
  }

  private static void startChrome() throws IOException, InterruptedException {
    Process process = Runtime.getRuntime().exec("\"C:/Program Files (x86)/Google/Chrome/Application/chrome.exe\"");
    process.waitFor();
    System.out.println("Google Chrome launched");
  }

  private static void setClipboardContent(String text) {
    CLIPBOARD.setContents(new StringSelection(text), null);
  }

  private static void enterURLFromClipboard() throws InterruptedException {
    // Ctrl-V
    ROBOT.keyPress(KeyEvent.VK_CONTROL);
    ROBOT.keyPress(KeyEvent.VK_V);
    ROBOT.keyRelease(KeyEvent.VK_V);
    ROBOT.keyRelease(KeyEvent.VK_CONTROL);
    // Enter
    ROBOT.keyPress(KeyEvent.VK_ENTER);
    ROBOT.keyRelease(KeyEvent.VK_ENTER);
    // Wait a little while
    Thread.sleep(250);
  }

  private static void createNewBrowserTab() {
    // Ctrl-T
    ROBOT.keyPress(KeyEvent.VK_CONTROL);
    ROBOT.keyPress(KeyEvent.VK_T);
    ROBOT.keyRelease(KeyEvent.VK_CONTROL);
    ROBOT.keyRelease(KeyEvent.VK_T);
  }
}
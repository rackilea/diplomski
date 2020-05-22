try
{
InputStreamReader reader = new InputStreamReader(System.in);
while (!reader.ready()) { Thread.sleep(100); }
if (reader.read() > 0) { // interrupt this step and proceed to the next one }
}
catch (IOException e) { // do something }
catch (InterruptedException e) { // noone needs me anymore }
import java.security.*;

for (Provider provider: Security.getProviders()) {
  System.out.println(provider.getName());
  for (String key: provider.stringPropertyNames())
    System.out.println("\t" + key + "\t" + provider.getProperty(key));
}
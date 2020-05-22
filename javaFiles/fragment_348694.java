private Collection<ConfigurationOptionSetting> setEnvironmentProperties() {
    Collection<ConfigurationOptionSetting> configurationOptionSettings = new HashSet<>();
    configurationOptionSettings.add(new ConfigurationOptionSetting("aws:autoscaling:launchconfiguration", "InstanceType", "t2.medium"));
    configurationOptionSettings.add(new ConfigurationOptionSetting("aws:ec2:vpc", "VPCId","thevpcid");
    configurationOptionSettings.add(new ConfigurationOptionSetting("aws:ec2:vpc", "Subnets", "thesubnets");
    configurationOptionSettings.add(new ConfigurationOptionSetting("aws:ec2:vpc", "ELBSubnets", "theelbsubnets");
    configurationOptionSettings.add(new ConfigurationOptionSetting("aws:elasticbeanstalk:application:environment", "ANOTHER_PROPERTY", "a value"));
    return configurationOptionSettings;
}
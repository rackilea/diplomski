new SystemConfigurationObj(
        (String)values.get("SNMP_SERVER"),
        (int)values.get("SMTP_PORT"),
        (String)values.get("SNMP_USERNAME"),
        (String)values.get("SNMP_PASSWORD"),
        (boolean)values.get("IS_SSL")
    );
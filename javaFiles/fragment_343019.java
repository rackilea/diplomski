// Where you initalize the application-wide Configuration singleton:
Configuration cfg = ...;

Map<String, TemplateNumberFormatFactory> customNumberFormats = new HashMap<>();
customNumberFormats.put("price",
        new AliasTemplateNumberFormatFactory(",000.00"));
customNumberFormats.put("weight",
        new AliasTemplateNumberFormatFactory("0.##;; roundingMode=halfUp"));
cfg.setCustomNumberFormats(customNumberFormats);
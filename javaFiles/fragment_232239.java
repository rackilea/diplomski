CREATE TABLE `common_multilingualtexts` (
  `keyMultilingualText` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`keyMultilingualText`)
) ENGINE=MyISAM AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

CREATE TABLE `common_multilingualtexts_values` (
  `languageCode` varchar(5) NOT NULL,
  `keyMultilingualText` int(11) NOT NULL,
  `value` text,
  PRIMARY KEY  (`languageCode`,`keyMultilingualText`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
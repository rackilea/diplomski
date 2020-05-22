<file:inbound-endpoint connector-ref="fileConnector"
       path="${path}" 
       moveToDirectory="${move.path}"
       moveToPattern="#[message.inboundProperties['originalFilename']]" 
       comparator="your.package.comparators.YourComparator"
/>
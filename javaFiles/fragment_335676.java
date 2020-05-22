for (int page = 1; page <= numberOfPages; page++){
    try {
        SimpleTextExtractionStrategy strategy =
            parser.processContent(page, new SimpleTextExtractionStrategy());              
        content = content + strategy.getResultantText();
    } catch (Throwable t) { 
        crap=true;
        break;
    }
}
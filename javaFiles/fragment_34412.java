/**
         * get the index within the HSSFWorkbook (sequence within the collection of ExtnededFormat objects)
         * @return unique index number of the underlying record this style represents (probably you don't care
         *  unless you're comparing which one is which)
         */
        public short getIndex() {
            return _index;
        }
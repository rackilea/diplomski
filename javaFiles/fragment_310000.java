@XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "template"
    })
    public static class TemplateList {

        @XmlElement(name = "Template")
        protected List<String> template;

        /**
         * Gets the value of the template property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the template property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTemplate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getTemplate() {
            if (template == null) {
                template = new ArrayList<String>();
            }
            return this.template;
        }

        /**
         * Sets the value of the template property.
         * 
         * @param template
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTemplate(List<String> template) {
            this.template = template;
        }

    }
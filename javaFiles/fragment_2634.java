class CardResponseBuilder {

    private interface Builder {
        Object get();
    }

    private ObjectBuilder createObjectBuilder() {
        return new ObjectBuilder();
    }

    private static class ObjectBuilder implements Builder {
        Map<String, Object> map = new HashMap<>(5);

        ObjectBuilder add(String key, Object value) {
            map.put(key, value);
            return this;
        }

        ObjectBuilder add(String key, Builder builder) {
            return add(key, builder.get());
        }

        @Override
        public Map<String, Object> get() {
            return map;
        }
    }

    private ArrayBuilder createArrayBuilder() {
        return new ArrayBuilder();
    }

    private static class ArrayBuilder implements Builder {
        List<Object> list = new ArrayList<>(4);

        ArrayBuilder add(Builder builder) {
            list.add(builder.get());
            return this;
        }

        @Override
        public List<Object> get() {
            return list;
        }
    }

    public static final String UPDATE_MESSAGE = "UPDATE_MESSAGE";
    public static final String NEW_MESSAGE = "NEW_MESSAGE";

    private ObjectBuilder headerNode;
    private ObjectBuilder responseNode;
    private ArrayBuilder widgetsArray;
    private ArrayBuilder cardsArray;

    /**
     * Default public constructor.
     */
    public CardResponseBuilder() {
        this.responseNode = createObjectBuilder();
        this.cardsArray = createArrayBuilder();
        this.widgetsArray = createArrayBuilder();
    }

    /**
     * Creates a new CardResponseBuilder object for responding to an interactive card click.
     *
     * @param updateType the update type, either UPDATE_MESSAGE or NEW_MESSAGE.
     */
    public CardResponseBuilder(String updateType) {
        this();
        responseNode.add("actionResponse",
                createObjectBuilder().add("type", updateType));
    }

    /**
     * Adds a header to the card response.
     *
     * @param title    the header title
     * @param subtitle the header subtitle
     * @param imageUrl the header image
     * @return this CardResponseBuilder
     */
    public CardResponseBuilder header(String title, String subtitle, String imageUrl) {
        this.headerNode = createObjectBuilder()
                .add("header", createObjectBuilder()
                        .add("title", title)
                        .add("subtitle", subtitle)
                        .add("imageUrl", imageUrl)
                        .add("imageStyle", "IMAGE"));
        return this;
    }

    /**
     * Adds a TextParagraph widget to the card response.
     *
     * @param message the message in the text paragraph
     * @return this CardResponseBuilder
     */
    public CardResponseBuilder textParagraph(String message) {
        this.widgetsArray.add(
                createObjectBuilder()
                        .add("textParagraph",
                                createObjectBuilder().add("text", message)));
        return this;
    }

    /**
     * Adds a KeyValue widget to the card response.
     * <p>
     * For a list of icons that can be used, see:
     * https://developers.google.com/hangouts/chat/reference/message-formats/cards#builtinicons
     *
     * @param key         the key or top label
     * @param value       the value or content
     * @param bottomLabel the content below the key/value pair
     * @param iconName    a specific icon
     * @return this CardResponseBuilder
     */
    public CardResponseBuilder keyValue(String key, String value,
                                        String bottomLabel, String iconName) {
        this.widgetsArray.add(createObjectBuilder()
                .add("keyValue", createObjectBuilder()
                        .add("topLabel", key)
                        .add("content", value)
                        .add("bottomLabel", bottomLabel)
                        .add("icon", iconName)));
        return this;
    }

    /**
     * Adds an Image widget to the card response.
     *
     * @param imageUrl    the URL of the image to display
     * @param redirectUrl the URL to open when the image is clicked.
     * @return this CardResponseBuilder
     */
    public CardResponseBuilder image(String imageUrl, String redirectUrl) {
        this.widgetsArray.add(createObjectBuilder()
                .add("image", createObjectBuilder()
                        .add("imageUrl", imageUrl)
                        .add("onClick", createObjectBuilder()
                                .add("openLink", createObjectBuilder()
                                        .add("url", redirectUrl)))));
        return this;
    }

    /**
     * Adds a Text Button widget to the card response.
     * <p>
     * When clicked, the button opens a link in the user's browser.
     *
     * @param text        the text on the button
     * @param redirectUrl the link to open
     * @return this CardResponseBuilder
     */
    public CardResponseBuilder textButton(String text, String redirectUrl) {
        this.widgetsArray.add(createObjectBuilder()
                .add("buttons", createArrayBuilder()
                        .add(createObjectBuilder()
                                .add("textButton", createObjectBuilder()
                                        .add("text", text)
                                        .add("onClick", createObjectBuilder()
                                                .add("openLink", createObjectBuilder()
                                                        .add("url", redirectUrl)))))));
        return this;
    }

    /**
     * Adds an Image Button widget to the card response.
     * <p>
     * When clicked, the button opens a link in the user's browser.
     *
     * @param iconName    the icon to display
     * @param redirectUrl the link to open
     * @return this CardResponseBuilder
     */
    public CardResponseBuilder imageButton(String iconName, String redirectUrl) {
        this.widgetsArray.add(createObjectBuilder()
                .add("buttons", createArrayBuilder()
                        .add(createObjectBuilder()
                                .add("imageButton", createObjectBuilder()
                                        .add("icon", iconName)
                                        .add("onClick", createObjectBuilder()
                                                .add("openLink", createObjectBuilder()
                                                        .add("url", redirectUrl)))))));
        return this;
    }

    /**
     * Adds an interactive Text Button widget to the card response.
     * <p>
     * When clicked, the button sends a new request to the bot, passing along the custom actionName
     * and parameter values. The actionName and parameter values are defined by the developer when the
     * widget is first declared (as shown below).
     *
     * @param text                   the text to display
     * @param actionName             the custom action name
     * @param customActionParameters the custom key value pairs
     * @return this CardResponseBuilder
     */
    public CardResponseBuilder interactiveTextButton(String text, String actionName,
                                                     Map<String, String> customActionParameters) {

        // Define the custom action name and parameters for the interactive button.
        ObjectBuilder actionNode = createObjectBuilder()
                .add("actionMethodName", actionName);

        if (customActionParameters != null && customActionParameters.size() > 0) {
            addCustomActionParameters(actionNode, customActionParameters);
        }

        this.widgetsArray.add(createObjectBuilder()
                .add("buttons", createArrayBuilder()
                        .add(createObjectBuilder()
                                .add("textButton", createObjectBuilder()
                                        .add("text", text)
                                        .add("onClick", createObjectBuilder()
                                                .add("action", actionNode))))));
        return this;
    }

    /**
     * Adds an interactive Image Button widget to the card response.
     * <p>
     * When clicked, the button sends a new request to the bot, passing along the custom actionName
     * and parameter values. The actionName and parameter values are defined by the developer when the
     * widget is first declared (as shown below).
     *
     * @param iconName               the pre-defined icon to display.
     * @param actionName             the custom action name
     * @param customActionParameters the custom key value pairs
     * @return this CardResponseBuilder
     */
    public CardResponseBuilder interactiveImageButton(String iconName, String actionName,
                                                      Map<String, String> customActionParameters) {

        // Define the custom action name and parameters for the interactive button.
        ObjectBuilder actionNode = createObjectBuilder()
                .add("actionMethodName", actionName);

        if (customActionParameters != null && customActionParameters.size() > 0) {
            addCustomActionParameters(actionNode, customActionParameters);
        }

        this.widgetsArray.add(createObjectBuilder()
                .add("buttons", createArrayBuilder()
                        .add(createObjectBuilder()
                                .add("imageButton", createObjectBuilder()
                                        .add("icon", iconName)
                                        .add("onClick", createObjectBuilder()
                                                .add("action", actionNode))))));
        return this;
    }

    /**
     * Builds the card response and returns a JSON object node.
     *
     * @return card response as JSON-formatted string
     */
    public Object build() {

        // If you want your header to appear before all other cards,
        // you must add it to the `cards` array as the first / 0th item.
        if (this.headerNode != null) {
            this.cardsArray.add(this.headerNode);
        }

        return responseNode.add("cards", this.cardsArray
                .add(createObjectBuilder()
                        .add("sections", createArrayBuilder()
                                .add(createObjectBuilder()
                                        .add("widgets", this.widgetsArray)))))
                .get();
    }

    /**
     * Applies sets of custom parameters to the parameter field of an action.
     *
     * @param actionNode             the JSON action node
     * @param customActionParameters the parameters to apply to the custom action
     */
    private void addCustomActionParameters(ObjectBuilder actionNode,
                                           Map<String, String> customActionParameters) {
        ArrayBuilder parametersArray = createArrayBuilder();

        customActionParameters.forEach((k, v) -> {
            parametersArray.add(createObjectBuilder()
                    .add("key", k)
                    .add("value", v));
        });

        actionNode.add("parameters", parametersArray);
    }
}
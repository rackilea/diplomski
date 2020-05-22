/** redirect events to a sibling node (m_projectsWebView) */
    m_devicesLayer.addEventHandler(Event.ANY, event -> {
        if (!(event instanceof MouseEvent) {
            m_projectsWebView.fireEvent(event.copyFor(m_projectsWebView, m_projectsWebView));
        }
        event.consume();
    });
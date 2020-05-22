body {
        /* hide the horizontal scrollbar */
        overflow-x: hidden;
    }
    /* make the scrollbar a little wider */
    ::-webkit-scrollbar {
        width: 16px;
    }
    ::-webkit-scrollbar-track  {
        background-color: white;
    }
    /* the slider or "thumb" has some rounded edges and a shadow and it's a little translucent */
    ::-webkit-scrollbar-thumb {
        border-radius: 6px;
        box-shadow: inset 0 0 6px rgba(0,0,0,0.5); 
        background: rgba(159,216,239,0.8);
    }
    /* I don't like the scrollbar to be so tiny on large documents - hence I set a minimum height */
    ::-webkit-scrollbar-thumb:vertical {
        min-height: 100px;
    }
    /* Use a more translucent slider when the window is inactive */
    ::-webkit-scrollbar-thumb:window-inactive {
        background: rgba(159,216,239,0.2); 
    }
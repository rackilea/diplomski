.responsive-layout {
    display: grid !important;
    grid-template-rows: auto;
    grid-template-columns: 1fr 1fr;
    display: -ms-grid !important; /* IE */
    -ms-grid-rows: auto; /* IE */
    -ms-grid-columns: 1fr 1fr;  /* IE */
}

.label-one {
    grid-column: 1;
    -ms-grid-column: 1;  /* IE */
}

.label-two {
    grid-column: 2;
    -ms-grid-column: 2;  /* IE */
}

@media all and (max-width : 992px) {
    .responsive-layout {
        grid-template-columns: 1fr;
        -ms-grid-columns: 1fr;  /* IE */
    }

    .label-one {
        grid-column: 1;
        -ms-grid-column: 1;  /* IE */
    }

    .label-two {
        grid-column: 1;
        -ms-grid-column: 1;  /* IE */
    }
}
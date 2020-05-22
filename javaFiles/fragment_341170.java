<rich:fileUpload immediate="true" id="fileUploadId" 
                        ajaxSingle="true" listHeight="70px" listWidth="500px"
                        uploadButtonClass="otherButton" styleClass="backgroundColorInput"
                        addButtonClass="otherButton"
                        fileUploadListener="#{paramActions.fileUploadListener}">
                        <a:support event="onuploadcomplete" reRender="paramsForm" />
                    </rich:fileUpload>
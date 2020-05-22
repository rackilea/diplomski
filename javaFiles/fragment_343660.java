<form ui-jp="parsley" th:action="@{/show/products}" th:object="${myFormObject}" method="get">
                            <div class="row m-b">
                                <div class="col-sm-6">
                                    Search by Name: <input id="filter" type="text" th:field="*{pName}" class="form-control input-sm w-auto inline m-r"/>
                                    <button class="md-btn md-fab m-b-sm indigo"><i class="material-icons md-24">&#xe8b6;</i></button>
                                </div>
                            </div>
                        </form>
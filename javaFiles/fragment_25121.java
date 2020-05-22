<div id="portfoliolist" >
                    <div class="portfolio usado escambolivre" data-cat="usado escambolivre" th:each="produto : ${estoque}">
                        <div class="portfolio-wrapper"> 
                        <a rel="group" title=""  th:href="'/produto?id='+${produto.id}">
                            <img th:src="'images/'+${produto.id}+'.jpg'" alt=""  class="img-responsive caixa-img-produto" />
                        </a>
                            <div class="label">
                                <div class="label-text">
                                    <span class="text-category" th:text="${produto.nome}"></span>
                                </div>
                                <div class="label-bg"></div>
                            </div>
                        </div>
                    </div>
                </div>
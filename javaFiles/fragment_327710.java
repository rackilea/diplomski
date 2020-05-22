<#if supplier?? && supplier.vouchers?? > 
    <#list supplier.vouchers as voucher>
        <fo:table-cell padding-left="3px" column-width="200px" text-align="center" border="1px solid black">
            <fo:block>${voucher.creditTerm}</fo:block>
        </fo:table-cell>
    </#list>
</#if>